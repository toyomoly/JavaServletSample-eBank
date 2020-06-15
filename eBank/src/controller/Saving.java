package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.History;
import bean.User;
import dao.HistoryDAO;

@WebServlet(urlPatterns = { "/saving" })
public class Saving extends SuperController {

	// 預金画面表示
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ログイン判定
		if (!this.isLoginSession(req)) {
			// 未ログインなのでログイン画面へ
			res.sendRedirect("./login");
			return;
		}

		User user = this.getLoginUser(req);
		HistoryDAO historyDao = new HistoryDAO();
		List<History> items = historyDao.findByUserId(user.getUserId());

		// requestスコープにデータセット
		req.setAttribute("histories", items);

		RequestDispatcher dispacher = req.getRequestDispatcher("/saving.jsp");
		dispacher.forward(req, res);
	}

	// フォームから送信された場合
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ログイン判定
		if (!this.isLoginSession(req)) {
			// 未ログインなのでログイン画面へ
			res.sendRedirect("./login");
			return;
		}

		try {
			// リクエストパラメータ取得
			int price = Integer.parseInt(req.getParameter("price"));
			int status = Integer.parseInt(req.getParameter("status")); // 1:入金, 2:出金

			System.out.println(price);
			System.out.println(status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		User user = this.getLoginUser(req);
		HistoryDAO historyDao = new HistoryDAO();
		List<History> items = historyDao.findByUserId(user.getUserId());

		// requestスコープにデータセット
		req.setAttribute("histories", items);

		RequestDispatcher dispacher = req.getRequestDispatcher("/saving.jsp");
		dispacher.forward(req, res);
	}

}
