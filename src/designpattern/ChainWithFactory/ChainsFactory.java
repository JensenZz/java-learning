package designpattern.ChainWithFactory;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company:XXXXXX </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 16/3/25
 */

public class ChainsFactory {

    private HandleService oneHandleService;

    private HandleService twoHandleService;

    //此处也可注入
    public ChainsFactory() {
        oneHandleService = new OneHandle();
        twoHandleService = new TwoHandle();
    }

    public void setOneHandleService(HandleService oneHandleService) {
        this.oneHandleService = oneHandleService;
    }

    public void setTwoHandleService(HandleService twoHandleService) {
        this.twoHandleService = twoHandleService;
    }

    public HandleService produce(int i) {
        switch (i) {
            case 1:
                return oneHandleService;
            case 2:
                return twoHandleService;
            default:
                return null;
        }
    }
}
