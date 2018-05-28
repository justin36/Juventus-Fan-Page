package global.sesoc.test6.vo;

public class Bulletin {
	
	private int bulletinnum;
	private String id;
	private String title;
	private String content;
	private String inputdate;
	private int hits;
	
	public Bulletin(int bulletinnum, String id, String title, String content, String inputdate, int hits) {
		this.bulletinnum = bulletinnum;
		this.id = id;
		this.title = title;
		this.content = content;
		this.inputdate = inputdate;
		this.hits = hits;
	}
	
	public Bulletin() {
		
	}

	public int getBulletinnum() {
		return bulletinnum;
	}

	public void setBulletinnum(int bulletinnum) {
		this.bulletinnum = bulletinnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getinputdate() {
		return inputdate;
	}

	public void setinputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "Bulletin [bulletinnum=" + bulletinnum + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", inputdate=" + inputdate + ", hits=" + hits + "]";
	}

}
