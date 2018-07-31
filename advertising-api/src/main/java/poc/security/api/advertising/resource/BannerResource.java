package poc.security.api.advertising.resource;

/*
 * Resource representing an whisky.
 */
public class BannerResource {

	private String id;

	private String html;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}


	public static final class BannerResourceBuilder {

		private BannerResource objectToBuild;

		private BannerResourceBuilder() {
			objectToBuild = new BannerResource();
		}

		public static BannerResourceBuilder aBannerResource() {
			return new BannerResourceBuilder();
		}

		public BannerResourceBuilder id(String id) {
			objectToBuild.setId(id);
			return this;
		}

		public BannerResourceBuilder html(String html) {
			objectToBuild.setHtml(html);
			return this;
		}

		public BannerResource build() {
			return objectToBuild;
		}
	}
}
