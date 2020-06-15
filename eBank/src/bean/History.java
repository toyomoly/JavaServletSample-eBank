package bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class History {

	private String userId;
	private int status;
	private int price;
	private LocalDateTime createdAt;

	public History(String userId, int status, int price, LocalDateTime createdAt) {
		this.userId = userId;
		this.status = status;
		this.price = price;
		this.createdAt = createdAt;
	}

	public String getUserId() {
		return userId;
	}

	public int getStatus() {
		return status;
	}

	public String getStatusName() {
		switch (this.status) {
		case 1:
			return "入金";
		case 2:
			return "出金";
		default:
			return "不明";
		}
	}

	public int getPrice() {
		return price;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getCreatedAtDisplayString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return this.createdAt.format(formatter);
	}
}
