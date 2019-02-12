package cn.tedu.spring;

public class JsonResult {

    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public JsonResult(Integer state) {
        super();
        this.state = state;
    }
    
    
}
