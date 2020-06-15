package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/logout" })
public class Logout extends SuperController {

	// ログアウト画面表示
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ログアウト処理
		this.invalidateSession(req);

		RequestDispatcher dispacher = req.getRequestDispatcher("/logout.jsp");
		dispacher.forward(req, res);
	}

}
