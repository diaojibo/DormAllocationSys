function checkone()
{ 
  if (one.dorm.value=="null") {
    alert("宿舍楼号不能为空!");
    return false;
  }
  return true;
} 

function checkthree()
{ 
  if (three.faculty.value==" "&&three.department.value==" "&&three.classnumber.value=="null") {
    alert("三项不能全为空!");
    return false;
  }
  return true;
} 

function Dsy() 
{ 
  this.Items = {}; 
} 
  Dsy.prototype.add = function(id,iArray) 
{ 
  this.Items[id] = iArray; 
} 
  Dsy.prototype.Exists = function(id) 
{ 
  if(typeof(this.Items[id]) == "undefined") return false; 
  return true; 
} 
function change(v){ 
  var str="0"; 
  for(i=0;i<v;i++){ str+=("_"+(document.getElementById(s[i]).selectedIndex-1));}; 
  var ss=document.getElementById(s[v]); 
  with(ss){ 
    length = 0; 
    options[0]=new Option(opt0[v],opt0[v]); 
    if(v && document.getElementById(s[v-1]).selectedIndex>0 || !v) 
    { 
      if(dsy.Exists(str)){ 
        ar = dsy.Items[str]; 
        for(i=0;i<ar.length;i++)options[length]=new Option(ar[i],ar[i]); 
        if(v)options[1].selected = true;
        } 
      } 
    if(++v<s.length){change(v);} 
    } 
  } 
  var dsy = new Dsy(); 
  dsy.add("0",["英语语言文化学院","国际经济贸易学院","国际商务英语学院","国际工商管理学院",
        "财经学院","西方语言文化学院","东方语言文化学院","中国语言文化学院","法学院",
        "英语教育学院","思科信息学院","政治与公共管理学院","高级翻译学院","新闻与传播学院","艺术学院"]); 
  dsy.add("0_0",["英语（语言信息管理）","英语（国际会展与旅游）","英语（文化与传播）",
         "英语（高级翻译）","英语（英美文学）","英语（语言学）"]); 
  dsy.add("0_1",["金融工程","保险","经济学","金融学","国际经济与贸易"]); 
  dsy.add("0_2",["国际商务","英语"]); 
  dsy.add("0_3",["市场营销","人力资源管理","物流管理","工商管理","电子商务"]); 
  dsy.add("0_4",["财政学","税务","审计学","财务管理","会计学"]); 
  dsy.add("0_5",["葡萄牙语","意大利语","西班牙语","俄语","德语","法语"]); 
  dsy.add("0_6",["阿拉伯语","朝鲜语","越南语","泰语","印度尼西亚语","日语"]); 
  dsy.add("0_7",["对外汉语","汉语言","汉语言文学"]); 
  dsy.add("0_8",["国际政治","外交学","法学"]); 
  dsy.add("0_9",["教育学"]); 
  dsy.add("0_10",["信息管理与信息系统","数学与应用数学","统计学","网络工程","软件工程","计算机科学与技术"]); 
  dsy.add("0_11",["社会工作","应用心理学","公共事业管理","行政管理"]); 
  dsy.add("0_12",["翻译"]); 
  dsy.add("0_13",["播音与主持艺术","广告学","新闻学"]); 
  dsy.add("0_14",["音乐学","舞蹈学","艺术设计","音乐表演"]); 


var s=["s1","s2"]; 
var opt0 = [" "," "]; 
function setup() 
{ 
  for(i=0;i<s.length-1;i++) {
  document.getElementById(s[i]).onchange=new Function("change("+(i+1)+")"); 
  change(0); }
} 
