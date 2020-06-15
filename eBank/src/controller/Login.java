package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;

@WebServlet(urlPatterns = { "/login" })
public class Login extends SuperController {

	// ログイン画面表示
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ログイン判定
		if (this.isLoginSession(req)) {
			// 既にログインしている時はsaving画面へ
			res.sendRedirect("./saving");
		} else {
			RequestDispatcher dispacher = req.getRequestDispatcher("/login.jsp");
			dispacher.forward(req, res);
		}
	}

	// 送信ボタンを押したときの処理
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String userId = req.getParameter("user-id");
		String password = req.getParameter("password");

		// ログイン判定
		User user = this.login(userId, password);
		if (user != null) {
			// ログイン成功時
			this.setLoginSession(req, user);

			// saving画面へ
			res.sendRedirect("./saving");

		} else {
			// ログイン失敗時
			req.setAttribute("loginError", true);
			req.setAttribute("message", "ユーザー名またはパスワードが違います");
			this.invalidateSession(req);

			RequestDispatcher dispacher = req.getRequestDispatcher("/login.jsp");
			dispacher.forward(req, res);
		}
	}

	// 入力されたユーザーID,パスワードでユーザー情報を取得
	private User login(String userId, String password) {

		UserDAO userDao = new UserDAO();
		User user = userDao.findByUserId(userId);
		if ((user != null) && (user.equalsPassword(password))) {
			return user;
		} else {
			return null;
		}
	}

	// sessionにログイン情報を登録
	private void setLoginSession(HttpServletRequest req, User user) {
		HttpSession session = req.getSession();
		session.setAttribute("loginUser", user);
	}

}
