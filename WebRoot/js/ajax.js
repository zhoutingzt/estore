function createAjax(){
    	var ajax=null;
    	try{
    		ajax=new ActiveXObject("microsoft.xml");
    		
    	}catch(e1){
    		try{
    			ajax=new XMLHttpRequest();
    		}catch(e2){
    			alert("你的浏览器不支持异步交互 请换其他浏览器");
    			
    		}
    		
    	}
    	return ajax;
}