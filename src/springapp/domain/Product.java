package springapp.domain;

public class Product {
	private int id;
	private String description;
	private Double price;

	public Product() {
	}

	public Product(int id, String description, Double price) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: " + description + ";");
		buffer.append("Price: " + price);
		return buffer.toString();
	}
}
