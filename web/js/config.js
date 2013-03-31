seajs.config({
  // 配置别名
  alias: {
    'jquery': 'js/jquery-1.8.0.js', 
    'bootstrap': 'bootstrap/js/bootstrap.min.js', 
    'form': 'js/jquery.form.js', 
    'pagination': 'js/jquery.pagination.js', 
    'bootstrap.extension': 'js/jquery.bootstrap.extension.js', 
    'util': 'js/1000funs.js'
  },

  // 加载 shim 插件
  plugins: ['shim'],

  // 配置 shim 信息，这样我们就可以通过 require('jquery') 来获取 jQuery
  shim: {
    'jquery': {
    	exports: 'jQuery'
    }
  }
});