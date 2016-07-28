package myTest;

/**
 * Created by JensenZz on 16/1/8.
 * Project name is sbkj-b2b-mall
 * O(∩_∩)O ^_^
 * 创建一个Parameter类，采用键值对的方式存储请求携带的参数。如果直接使用HashMap数据结构进行存储，由于其底层的设计原则，将无法避免客户端浏览器重复提交的问题。
 */
public class MyPatameter {

    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final MyPatameter other = (MyPatameter) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
