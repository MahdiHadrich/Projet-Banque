function deleteClient(cin) {
	
	swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this Client!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  $.ajax({
					url : "ClientServlet",
					type : "POST",
					data : {
						action : "delete",
						cin : cin
					},
					success : function() {
						$("#tr" + cin).remove();
						swal("Your Client has been deleted!", {
						      icon: "success",
						    });
					},
					error : function() {
						swal("Poof! server error!", {
						      icon: "error",
						    });
					}
				});
		  } 
		});
}