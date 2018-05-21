package cn.lastlysly.myutils;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-05-13 13:14
 * 这是自定义的一个输出格式
 **/
public class MyResult {
    public int code;
    public String tip;
    public Object data;

    public MyResult(int code, String tip, Object data) {
        this.code = code;
        this.tip = tip;
        this.data = data;
    }

    public MyResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
