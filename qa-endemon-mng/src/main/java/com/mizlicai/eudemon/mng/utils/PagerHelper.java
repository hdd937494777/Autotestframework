//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.mizlicai.eudemon.mng.utils;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class PagerHelper<E> {
    private String baseUrl;
    private String anchor;
    private String content;
    private PageInfo<E> pager;
    private Map<String, String> params = new HashMap();
    private int size = 5;
    public static final int DEFAULT_PAGE_SIZE = 20;

    public PagerHelper() {
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getContent() {
        this.content = this.render();
        return this.content;
    }

    public PageInfo<E> getPager() {
        return this.pager;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public int getSize() {
        return this.size;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPager(PageInfo<E> pager) {
        this.pager = pager;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private String pieceString(String paraStr, int size, String content, int startPager) {
        for(int i = 0; i < size; ++i) {
            if(startPager + i == this.pager.getPageNum()) {
                content = content + "<a href=\"" + this.baseUrl + "?" + paraStr + "pageNum=" + (startPager + i) + "&pageSize=" + this.pager.getPageSize() + (StringUtils.isNotBlank(anchor) ? ("#" + anchor) : "") + "\" class=\"btn disabled large bg-gray\">" + (startPager + i) + "</a>";
            } else {
                content = content + "<a href=\"" + this.baseUrl + "?" + paraStr + "pageNum=" + (startPager + i) + "&pageSize=" + this.pager.getPageSize() + (StringUtils.isNotBlank(anchor) ? ("#" + anchor) : "") + "\" class=\"btn large bg-gray\">" + (startPager + i) + "</a>";
            }
        }

        return content;
    }

    private String render() {
        String paraStr = "";
        Iterator iterator = this.params.entrySet().iterator();

        String next;
        String head;
        while(iterator.hasNext()) {
            Entry pre = (Entry)iterator.next();
            next = (String)pre.getKey();
            head = (String)pre.getValue();
            if(!paraStr.equals("")) {
                paraStr = paraStr + "&" + next + "=" + head;
            } else {
                paraStr = paraStr + next + "=" + head;
            }
        }

        if(!paraStr.equals("")) {
            paraStr = paraStr + "&";
        }

        String var12 = "<a href=\"" + this.baseUrl + "?" + paraStr + "pageNum=" + (this.pager.getPageNum() - this.size) + "&pageSize=" + this.pager.getPageSize() + (StringUtils.isNotBlank(anchor) ? ("#" + anchor) : "") + "\" class=\"btn large bg-white\">" + "<i class=\"glyph-icon icon-chevron-left\"></i>" + "</a>";
        next = "<a href=\"" + this.baseUrl + "?" + paraStr + "pageNum=" + (this.pager.getPageNum() + this.size) + "&pageSize=" + this.pager.getPageSize() + (StringUtils.isNotBlank(anchor) ? ("#" + anchor) : "") + "\" class=\"btn large bg-white\">" + "<i class=\"glyph-icon icon-chevron-right\"></i>" + "</a>";
        head = "<a href=\"" + this.baseUrl + "?" + paraStr + "pageNum=1" + "&pageSize=" + this.pager.getPageSize() + (StringUtils.isNotBlank(anchor) ? ("#" + anchor) : "") + "\" class=\"btn large bg-gray\">1</a>";
        String end = "<a href=\"" + this.baseUrl + "?" + paraStr + "pageNum=" + this.pager.getPages() + "&pageSize=" + this.pager.getPageSize() + (StringUtils.isNotBlank(anchor) ? ("#" + anchor) : "") + "\" class=\"btn large bg-gray\">" + this.pager.getPages() + "</a>";
        String leaveout = "<a href=\"javascript:;\" class=\"btn large bg-gray\">...</a>";
        String content = "";
        String str = "";
        int startPager = this.pager.getPageNum() - this.size / 2 < 1?1:this.pager.getPageNum() - this.size / 2;
        if(this.pager.getPages()<= this.size) {
            for(int input = 0; input < this.pager.getPages(); ++input) {
                if(this.pager.getPageNum() == 1 + input) {
                    content = content + "<a href=\"" + this.baseUrl + "?" + paraStr + "pageNum=" + (1 + input) + "&pageSize=" + this.pager.getPageSize() + (StringUtils.isNotBlank(anchor) ? ("#" + anchor) : "") + "\" class=\"btn disabled large bg-gray\">" + (1 + input) + "</a>";
                } else {
                    content = content + "<a href=\"" + this.baseUrl + "?" + paraStr + "pageNum=" + (1 + input) + "&pageSize=" + this.pager.getPageSize() + (StringUtils.isNotBlank(anchor) ? ("#" + anchor) : "") + "\" class=\"btn large bg-gray\">" + (1 + input) + "</a>";
                }
            }

            str = content;
        } else if(startPager < this.size / 2) {
            content = this.pieceString(paraStr, this.size, content, startPager);
            if(startPager == 1) {
                str = content + "<a href=\"javascript:;\" class=\"btn large bg-gray\">...</a>" + end;
            } else {
                str = head + "<a href=\"javascript:;\" class=\"btn large bg-gray\">...</a>" + content + "<a href=\"javascript:;\" class=\"btn large bg-gray\">...</a>" + end;
            }

            if(this.pager.getPageNum() + this.size < this.pager.getPages()) {
                str = str + next;
            }
        } else if(startPager > this.pager.getPages() - this.size) {
            startPager = this.pager.getPages() - this.size + 1;
            content = this.pieceString(paraStr, this.size, content, startPager);
            if(this.pager.getPageNum() - this.size >= 1) {
                str = var12;
            }

            str = str + head + "<a href=\"javascript:;\" class=\"btn large bg-gray\">...</a>" + content;
        } else {
            content = this.pieceString(paraStr, this.size, content, startPager);
            if(this.pager.getPageNum() + this.size > this.pager.getPages()) {
                str = var12 + head + "<a href=\"javascript:;\" class=\"btn large bg-gray\">...</a>" + content + "<a href=\"javascript:;\" class=\"btn large bg-gray\">...</a>" + end;
            } else if(this.pager.getPageNum() - this.size < 1) {
                str = head + "<a href=\"javascript:;\" class=\"btn large bg-gray\">...</a>" + content + "<a href=\"javascript:;\" class=\"btn large bg-gray\">...</a>" + end + next;
            } else {
                str = var12 + head + "<a href=\"javascript:;\" class=\"btn large bg-gray\">...</a>" + content + "<a href=\"javascript:;\" class=\"btn large bg-gray\">...</a>" + end + next;
            }
        }

        String var13 = "&nbsp&nbsp<input id=\"pageNum\" style=\"width:30px\" data-last-page=\"" + this.pager.getPages() + "\"  placeholder=\"" + this.pager.getPageNum() + "\" value=\"" + this.pager.getPageNum() + "\" type=\"text\">" + "<input type=\"button\" value=\"确定\" style=\"width: 40px\" onclick=\"if($(\'#pageNum\').val()<1 || $(\'#pageNum\').val()>$(\'#pageNum\').data(\'lastPage\')){alert(\'超出界限！\');return;}location.assign(\'" + this.baseUrl + "?" + paraStr + "pageNum=\'+$(\'#pageNum\').val()+\'&pageSize=" + this.pager.getPageSize() + (StringUtils.isNotBlank(anchor) ? ("#" + anchor) : "") + "\')\"/>";
        str = str + var13;
        return str;
    }
}
