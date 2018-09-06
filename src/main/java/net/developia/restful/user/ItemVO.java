package net.developia.restful.user;

public class ItemVO {
	private String id;
	private String value;
	private String label;
	
	
	public ItemVO() {
	}
	public ItemVO(String id, String value, String label) {
		super();
		this.id = id;
		this.value = value;
		this.label = label;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String toString() {
		return "ItemVO [id=" + id + ", value=" + value + ", label=" + label + "]";
	}
	
	
	
}
