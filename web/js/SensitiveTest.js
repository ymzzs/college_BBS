var keywords=["黑框眼镜","江泽民","续命","续一秒","膜蛤","苟利国家生死以","岂因祸福避趋之","中国猪","台湾猪",
    "震死他们","贱人","装b","大sb","傻逼","傻b","煞逼","煞笔","刹笔","傻比","沙比","欠干","婊子养的","我日你",
    "我操","我草","卧艹","卧槽","爆你菊","艹你","cao你","你他妈","真他妈","别他吗","草你吗","草你丫","操你妈","擦你妈","操你娘","操他妈",
    "日你妈","干你妈","干你娘","娘西皮","狗操","狗草","狗杂种","狗日的","操你祖宗","操你全家","操你大爷","妈逼","你麻痹","麻痹的",
    "妈了个逼","马勒","狗娘养","贱比","贱b","下贱","死全家","全家死光","全家不得好死","全家死绝","白痴","无耻","杀b","你吗b",
    "你妈的","婊子","贱货","人渣","混蛋","媚外","和弦","兼职","限量","铃声","性伴侣","男公关","火辣","精子","射精","诱奸","强奸","做爱",
    "性爱","发生关系","按摩","快感","处男","猛男","少妇","屌","屁股","下体","a片","内裤","浑圆","咪咪","发情","刺激","白嫩","粉嫩",
    "兽性","风骚","呻吟","阉割","高潮","裸露","不穿","一丝不挂","脱光","干你","干死","我干","中日没有不友好的","货到付款",
    "木牛流马的污染比汽车飞机大","他们嫌我挡了城市的道路","当官靠后台","警察我们是为人民服务的","中石化说亏损","王八"];

//检测敏感词
function _filter_method(obj){
    //获取文本输入框中的内容
    var value = $(obj).val();
    console.log(value);
    //遍历敏感词数组
    for(var i=0;i<keywords.length;i++){
        //全局替换
        var reg = new RegExp(keywords[i],"g");
        //判断内容中是否包括敏感词
        if(value.indexOf(keywords[i]) != -1){
            alert("包含敏感词汇：" + keywords[i]);
            return false;
        }
    }
    return true;
}

//检测敏感词
function _sensitive_test(value){
    //遍历敏感词数组
    for(var i=0;i<keywords.length;i++){
        //全局替换
        var reg = new RegExp(keywords[i],"g");
        //判断内容中是否包括敏感词
        if(value.indexOf(keywords[i]) != -1){
            alert("包含敏感词汇：" + keywords[i]);
            return false;
        }
    }
    return true;
}