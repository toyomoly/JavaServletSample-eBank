package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.User;

public class SuperController extends HttpServlet {

	// session情報を全て削除
	void invalidateSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
	}

	// sessionにログイン情報があるかどうかチェック
	protected boolean isLoginSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return (session.getAttribute("loginUser") != null);
	}

	// sessionからユーザー情報を取得
	protected User getLoginUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return (User) session.getAttribute("loginUser");
	}
}
