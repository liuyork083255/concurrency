package liu.york.concurrent.threadlocal;

/**
 * 可以应用在过滤器中，将请求的基本信息保存在 thread local 中
 * 但是这里使用的是在 interceptor 中进行删除的  而不是在 finally 中删除
 */
public class RequestHolder {

    private static final ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    /**
     * 必须要有删除， 否则会造成内存泄露
     */
    public static void remove(){
        requestHolder.remove();
    }

}
