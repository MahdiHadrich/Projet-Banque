function deleteCompte(rib) {
	
	swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this Compte!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  $.ajax({
					url : "CompteServlet",
					type : "POST",
					data : {
						action : "delete",
						rib : rib
					},
					success : function() {
						$("#tr" + rib).remove();
						swal("Your Compte has been deleted!", {
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


