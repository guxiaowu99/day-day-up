package io.study.common.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangmengchao
 * @date 2020-04-29
 */
@Data
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = -7678295014430069646L;

    /**
     * 当前页
     */
    private int page;
    /**
     * 每页大小
     */
    private int size;
    /**
     * 总数
     */
    private long total;
    /**
     * 当前页内容
     */
    private List<T> content;

    public PageInfo(int page, int size, long total, List<T> content) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.content = content;
    }

}
