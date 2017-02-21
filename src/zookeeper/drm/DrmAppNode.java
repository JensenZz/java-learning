package zookeeper.drm;

/**
 * <p>Title: Drm推送节点Bean</p>
 * <p>Description: Drm推送节点Bean<p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2017/2/17
 */

public class DrmAppNode {
    /**
     * 实体对象
     */
    private Object obj;
    /**
     * 属性名称
     */
    private String parmname;
    /**
     * 属性值
     */
    private String value;
    /**
     * 类名
     */
    private String classname;

    public DrmAppNode(Object obj, String parmname, String value) {
        this.obj = obj;
        this.parmname = parmname;
        this.value = value;
        this.classname = obj.getClass().getSimpleName();
    }

    public int hashCode() {
        boolean prime = true;
        byte result = 1;
        int result1 = 31 * result + (this.classname == null ? 0 : this.classname.hashCode());
        result1 = 31 * result1 + (this.obj == null ? 0 : this.obj.hashCode());
        result1 = 31 * result1 + (this.parmname == null ? 0 : this.parmname.hashCode());
        return result1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            DrmAppNode other = (DrmAppNode) obj;
            if (this.classname == null) {
                if (other.classname != null) {
                    return false;
                }
            } else if (!this.classname.equals(other.classname)) {
                return false;
            }

            if (this.obj == null) {
                if (other.obj != null) {
                    return false;
                }
            } else if (!this.obj.equals(other.obj)) {
                return false;
            }

            if (this.parmname == null) {
                if (other.parmname != null) {
                    return false;
                }
            } else if (!this.parmname.equals(other.parmname)) {
                return false;
            }

            return true;
        }
    }

    public Object getObj() {
        return this.obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getParmname() {
        return this.parmname;
    }

    public void setParmname(String parmname) {
        this.parmname = parmname;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getClassname() {
        return this.classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
