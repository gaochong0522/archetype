package archetype.common.factory;

public class Message<M extends Message> {
	//消息结果
	private String result;
	//消息内容
	private String info;
	//返回状态码
	private String status;
	//搭载的对象
	private Object retObj;
	
	
	public Object getRetObj() {
		return retObj;
	}
	public void setRetObj(Object retObj) {
		this.retObj = retObj;
	}
	public String getStatus() {
		return status;
	}
	public M setStatus(String status) {
		this.status = status;
		return (M)this;
	}
	public String getResult() {
		return result;
	}
	public M setResult(String result) {
		this.result = result;
		return (M) this;
	}
	public String getInfo() {
		return info;
	}
	public M setInfo(String info) {
		this.info = info;
		return (M) this;
	}
	//返回消息Str
	public String toString() {
		return "[status]" + this.status + " [result] " + this.result + " [info]" + this.info;
	}
}
