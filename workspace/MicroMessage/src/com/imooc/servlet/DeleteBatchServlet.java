package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.MaintainService;

/*
 * ����ɾ�����Ʋ�
 */
@SuppressWarnings("serial")
public class DeleteBatchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ���
		req.setCharacterEncoding("UTF-8");
		//����ҳ���ֵ
		String []ids=req.getParameterValues("id");
		MaintainService maintainService =new MaintainService();
		maintainService.deleteBatch(ids);
		//��ҳ����ת
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
