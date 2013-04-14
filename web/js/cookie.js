	//��ȡCookie�е�ֵ
	function getCookieVal(offset)
    {
        var endstr = document.cookie.indexOf(";", offset);
        if(endstr == -1)
        {
            endstr = document.cookie.length;
        }
        return unescape(document.cookie.substring(offset, endstr));
    }

    // ����ֵ��ȡCookie
    function getCookie(name)
    {
        var arg = name + "=";
        var alen = arg.length;
        var clen = document.cookie.length;
        var i = 0;
        while(i < clen)
        {
            var j = i + alen;
            if (document.cookie.substring(i, j) == arg)
            {
                return getCookieVal(j);
            }
            i = document.cookie.indexOf(" ", i) + 1;
            if(i == 0) break;
        }
        return "";
    }

    //��ֵ������Cookie��
    function setCookie(name, value, expires, path, domain, secure)
    {
        document.cookie = name + "=" + escape(value) +
            ((expires) ? "; expires=" + expires : "") +
            ((path) ? "; path=" + path : "") +
            ((domain) ? "; domain=" + domain : "") +
            ((secure) ? "; secure" : "");
    }

    //ͨ���趨Cookie����ʱ��ɾ��Cookie
    function deleteCookie(name,path,domain)
    {
        if(getCookie(name))
        {
        	var time = new Date();
        	time.setTime(time.getTime()   -  10000);
            document.cookie = name + "=" +
                ((path) ? "; path=" + path : "") +
                ((domain) ? "; domain=" + domain : "") +
                "; expires=" + time.toGMTString();
        }
    }