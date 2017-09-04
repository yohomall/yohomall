package com.yohomall.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yohomall.pojo.Cart;
import com.yohomall.pojo.CartItem;
import com.yohomall.pojo.Orderitem;
import com.yohomall.pojo.Orders;
import com.yohomall.pojo.User;
import com.yohomall.service.OrdersService;
import com.yohomall.service.impl.OrdersServiceImpl;
import com.yohomall.util.ContantUtil;
import com.yohomall.util.PageUtil;
import com.yohomall.util.PaymentUtil;
import com.yohomall.util.UUIDUtils;
/**
 * ����ģ��
 * @author Administrator
 *
 */
@Controller
public class OrderController {
	
	@Autowired
	private OrdersServiceImpl oservice;
	
	@RequestMapping(value="updateOrderStarus")
	public String updateStatus(String oid) throws Exception {
		Orders order= oservice.getByID(oid);
		
		order.setStatus(ContantUtil.ORDER_YIWANCHENG);
		
		oservice.update(order);
		
		
		return "redirect:/MyOrders.action?pageNum=1";
	}
	
	/**
	 * 
	 * @param order
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="saveOrder")
	public String save(HttpServletRequest request) throws Exception {
		
		User user=(User) request.getSession().getAttribute("user");
		if (user==null) {
			//δ��¼
			request.setAttribute("msg", "���ȵ�¼");
			return "/jsp/msg";
		}
		
		//��ȡ���ﳵ
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		Orders order=new Orders();
		//����oid
		order.setOid(UUIDUtils.getId());
		//����time
		order.setTime(new Date());
		//����status
		order.setStatus(ContantUtil.ORDER_WEIFUKUAN);
		//����total
		order.setTotal(cart.getTotal());
		//����user
		order.setUser(user);
		//����orderitems
		for(CartItem ci:cart.getCartItems()) {
			Orderitem orderitem=new Orderitem();
			//����itemid
			orderitem.setItemid(UUIDUtils.getId());
			//����subtotal
			orderitem.setSubtotal(ci.getSubtotal());
			//����count
			orderitem.setQuantity(ci.getCount());
			//����product
			orderitem.setProduct(ci.getProduct());
			//����order
			orderitem.setOrder(order);
			//��orderitem����orders��orderitems��
			order.getOrderitems().add(orderitem);
		}
		
		oservice.save(order);
		//��չ��ﳵ
		cart.clearCart();
		
		request.setAttribute("bean", order);
		
		return "/jsp/order_info";
	}
	/**
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="MyOrders")
	public String getMyOrdersByPage(HttpServletRequest request,Model model) throws Exception {
		
		PageUtil<Orders> pageUtil=new PageUtil<>();
		User user=(User) request.getSession().getAttribute("user");
		
		if (user==null) {
			//δ��¼
			request.setAttribute("msg", "���ȵ�¼");
			return "/jsp/msg";
		}
		
		int pageNum=Integer.valueOf(request.getParameter("pageNum"));
		pageUtil.setPageNum(pageNum);
		pageUtil.setPageSize(3);
		pageUtil.setTotalRecord(oservice.getTotalRecord(user.getUid()));
		int StartIndex=pageUtil.getStartIndex();
		
		List<Orders> list=oservice.getMyOrdersByPage(user.getUid(), StartIndex, pageUtil.getPageSize());
		
		pageUtil.setData(list);
		
		model.addAttribute("pb", pageUtil);
		
		return "/jsp/order_list";
	}
	
	@RequestMapping(value="getOrder")
	public String getByID(@RequestParam(value="oid") String oid,Model model) throws Exception {
		
		Orders order=oservice.getByID(oid);
		
		model.addAttribute("bean", order);
		
		return "/jsp/order_info1";
	}
	/**
	 * ����֧��
	 * @param request
	 * @param response
	 */
	
	@RequestMapping(value="pay",method= {RequestMethod.POST})
	public void pay(HttpServletRequest request,HttpServletResponse response) {
		try {
			//���ܲ���
					String addr=request.getParameter("addr");
					String aname=request.getParameter("aname");
					String phone=request.getParameter("phone");
					String oid=request.getParameter("oid");
					
					
					
					Orders order = oservice.getByID(oid);
					
					order.setAddr(addr);
					order.setAname(aname);
					order.setPhone(phone);
					
					//����order
					oservice.update(order);
					

					// ��֯����֧����˾��Ҫ��Щ����
					String pd_FrpId = request.getParameter("pd_FrpId");
					String p0_Cmd = "Buy";
					String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
					String p2_Order = oid;
					String p3_Amt = "0.01";
					String p4_Cur = "CNY";
					String p5_Pid = "";
					String p6_Pcat = "";
					String p7_Pdesc = "";
					// ֧���ɹ��ص���ַ ---- ������֧����˾����ʡ��û�����
					// ������֧�����Է�����ַ
					String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("responseURL");
					String p9_SAF = "";
					String pa_MP = "";
					String pr_NeedResponse = "1";
					// ����hmac ��Ҫ��Կ
					String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
					String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
							p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
							pd_FrpId, pr_NeedResponse, keyValue);
				
					
					//���͸�������
					StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
					sb.append("p0_Cmd=").append(p0_Cmd).append("&");
					sb.append("p1_MerId=").append(p1_MerId).append("&");
					sb.append("p2_Order=").append(p2_Order).append("&");
					sb.append("p3_Amt=").append(p3_Amt).append("&");
					sb.append("p4_Cur=").append(p4_Cur).append("&");
					sb.append("p5_Pid=").append(p5_Pid).append("&");
					sb.append("p6_Pcat=").append(p6_Pcat).append("&");
					sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
					sb.append("p8_Url=").append(p8_Url).append("&");
					sb.append("p9_SAF=").append(p9_SAF).append("&");
					sb.append("pa_MP=").append(pa_MP).append("&");
					sb.append("pd_FrpId=").append(pd_FrpId).append("&");
					sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
					sb.append("hmac=").append(hmac);
					
					response.sendRedirect(sb.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
				
	}
	
	@RequestMapping(value="callback")
	public String callback(HttpServletRequest request,HttpServletResponse response) {
		try {
			String p1_MerId = request.getParameter("p1_MerId");
			String r0_Cmd = request.getParameter("r0_Cmd");
			String r1_Code = request.getParameter("r1_Code");
			String r2_TrxId = request.getParameter("r2_TrxId");
			String r3_Amt = request.getParameter("r3_Amt");
			String r4_Cur = request.getParameter("r4_Cur");
			String r5_Pid = request.getParameter("r5_Pid");
			String r6_Order = request.getParameter("r6_Order");
			String r7_Uid = request.getParameter("r7_Uid");
			String r8_MP = request.getParameter("r8_MP");
			String r9_BType = request.getParameter("r9_BType");
			String rb_BankId = request.getParameter("rb_BankId");
			String ro_BankOrderId = request.getParameter("ro_BankOrderId");
			String rp_PayDate = request.getParameter("rp_PayDate");
			String rq_CardNo = request.getParameter("rq_CardNo");
			String ru_Trxtime = request.getParameter("ru_Trxtime");
			// ���У�� --- �ж��ǲ���֧����˾֪ͨ��
			String hmac = request.getParameter("hmac");
			String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
					"keyValue");

			// �Լ����������ݽ��м��� --- �Ƚ�֧����˾������hamc
			boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
					r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
					r8_MP, r9_BType, keyValue);
			if (isValid) {
				// ��Ӧ������Ч
				if (r9_BType.equals("1")) {
					// ������ض���
					System.out.println("111");
					request.setAttribute("msg", "���Ķ�����Ϊ:"+r6_Order+",���Ϊ:"+r3_Amt+"�Ѿ�֧���ɹ�,�ȴ�����~~");
					
				} else if (r9_BType.equals("2")) {
					// ��������Ե� --- ֧����˾֪ͨ��
					System.out.println("����ɹ���222");
					// �޸Ķ���״̬ Ϊ�Ѹ���
					// �ظ�֧����˾
					response.getWriter().print("success");
				}
				
				//�޸Ķ���״̬
				
				Orders order = oservice.getByID(r6_Order);
				order.setStatus(ContantUtil.ORDER_YIFUKUAN);
				
				oservice.update(order);
				
			} else {
				// ������Ч
				System.out.println("���ݱ��۸ģ�");
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/jsp/msg";
		
	}
	
}
