package poc.security.api.whisky.resource;

/*
 * Resource representing an whisky.
 */
public class WhiskyResource {

	private String id;

	private String name;

	private String brand;

	private String category;

	private Double price;

	private String taste;

	private String description;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static final class Builder {

		private WhiskyResource objectToBuild;

		private Builder() {
			objectToBuild = new WhiskyResource();
		}

		public static Builder aNewWhisky() {
			return new Builder();
		}

		public Builder id(String id) {
			objectToBuild.setId(id);
			return this;
		}

		public Builder name(String name) {
			objectToBuild.setName(name);
			return this;
		}

		public Builder brand(String brand) {
			objectToBuild.setBrand(brand);
			return this;
		}

		public Builder category(String category) {
			objectToBuild.setCategory(category);
			return this;
		}

		public Builder price(Double price) {
			objectToBuild.setPrice(price);
			return this;
		}

		public Builder taste(String taste) {
			objectToBuild.setTaste(taste);
			return this;
		}

		public Builder description(String description) {
			objectToBuild.setDescription(description);
			return this;
		}

		public WhiskyResource build() {
			return objectToBuild;
		}
	}
}
