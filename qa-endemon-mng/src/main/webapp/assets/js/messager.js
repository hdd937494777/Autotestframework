$.messager = (function() {

  var alert = function(title, message) {
    var model = $.messager.model;

    if (arguments.length < 2) {
      message = title || "";
      title   = "&nbsp;"
    }

    $("<div>" + message + "</div>").dialog({
        title:   title
        // override destroy methods;
      , onClose: function() {
          $(this).dialog("destroy");
        }
      , buttons: [{
            text: model.ok.text
          , classed: model.ok.classed || "btn-success"
          , click: function() {
              $(this).dialog("destroy");
            }
        }]
    });
  };

  var confirm = function(title, message, callback) {
    var model = $.messager.model;

    $("<div>" + message + "</div>").dialog({
        title:   title
        // override destroy methods;
      , onClose: function() {
          $(this).dialog("destroy");
        }
      , buttons: [{
          text: model.cancel.text
        , classed : model.cancel.classed || "btn-danger"
        , click: function() {
            $(this).dialog("destroy");
          }
      },{
            text: model.ok.text
          , classed: model.ok.classed || "btn-success"
          , click: function() {
              $(this).dialog("destroy");
              callback && callback();
            }
        }]
    });
  };
  
  var confirm2 = function(title, message,width,height, callback) {
		var model = $.messager.model;
		$("<div class='text-center'>" + message + "</div>")
				.dialog({
					title : title,
					minWidth : width,
					minHeight : height,
					
					// override destroy methods;
					onClose : function() {
						$(this).dialog("destroy");
					},
					buttons : [ {
						text : model.cancel.text,
						classed : model.cancel.classed || "btn-danger",
						click : function() {
							$(this).dialog("destroy");
						}
					}, {
						text : model.ok.text,
						classed : model.ok.classed || "btn-success",
						click : function() {
							$(this).dialog("destroy");
							callback && callback();
						}
					} ]
				});
	};

    var confirmCancel = function(title, message, callback, callbackcancel) {
        var model = $.messager.model;

        $("<div>" + message + "</div>").dialog({
            title:   title
            // override destroy methods;
            , onClose: function() {
                $(this).dialog("destroy");
            }
            , buttons: [{
                text: model.cancel.text,
                classed : model.cancel.classed || "btn-danger",
                click: function() {
                    $(this).dialog("destroy");
                    callbackcancel && callbackcancel();
                }
            },{
                text: model.ok.text,
                classed: model.ok.classed || "btn-success",
                click: function() {
                    $(this).dialog("destroy");
                    callback && callback();
                }
            }]
        });
    };

  return {
      alert:   alert, 
      confirm: confirm,
      confirm2 : confirm2,
      confirmCancel : confirmCancel
  };

})();


$.messager.model = {
    ok:{ text: "确定", classed: 'btn-default' },
	cancel: { text: "取消", classed: 'btn-error' }
};