$(function() {
	var $registerForm = $("#register");
	
	var $registerForm2=$("#register2");
	
	
		$registerForm.validate({

			rules: {
				fn: {
					required: true,
					lettersonly: true
				},
				em: {
					required: true,
					email: true
				},
				ps: {
					required: true,
					all:true
				},
				cps: {
					required: true,
					equalTo: '#password'
				},
				mb: {
					required: true,
					numericOnly: true,
					minlength: 9,
					maxlength: 10
				},
				pk: {
					required: true,
					all:true
				},
				ex: {
					required: true,
					all:true
				}
			},

			messages: {
				fn: {
					required: 'fullname is must be required',
					lettersonly: 'invalid name'

				},
				em: {
					required: 'email is must be required',
					email: 'invalid email',
				
				},
				ps: {
					required: 'password is must be required',
					all:'invalid password'
				},
				cps: {
					required: 'confirm password is must be required',
					equalTo: 'Password Mismatch'
				},
				mb: {
					required: 'Mob no is required',
					numericOnly: 'invalid mob no',
					minlength: 'mob no minimum 10 length',
					maxlength: 'invalid'
				},
				pk: {
					required: 'Primary skill is required',
					all:'invalid primary skill'
				},
				ex: {
					required: 'Experience is required',
					all:'invalid experience'
				},

			},

			errorPlacement: function(error, element) {
				if (element.is(":radio")) {
					error.appendTo(element.parents(".gen"));
				} else {
					error.insertAfter(element);
				}
			}

		})
	
	
	
		$registerForm2.validate({
            rules:{
                cn:{
                    required:true,
                    all:true
                },
                rna:{
                    required:true,
                    lettersonly:true
                },
                ad:{
                    required:true
                },
                mb:{
                    required:true,
                    numericOnly:true,
                    minlength: 9,
					maxlength: 10
                },
                em:{
                    required:true,
                    email:true
                },
                ps:{
                    required:true
                },
                cpwd:{
                    required:true,
                    equalTo:"#pwd"
                }
            },
            messages:{
                cn:{
                    required:'compnay name must be required',
                    all:'invalid company name'
                },
                rna:{
                    required:'recruiter name must be required',
                    lettersonly:'invalid name'
                },
                ad:{
                    required:'address must be required'
                },
                mb:{
                    required:'mob no must be required',
                    numericOnly:'mob no invalid',
                    minlength: 'mob no minimum 10 length',
					maxlength: 'invalid'
                },
                em:{
                    required:'email must be required',
                    email:'invalid email'
                },
                ps:{
                    required:'password must be required'
                },
                cpwd:{
                    required:'confirm password must be required',
                    equalTo:'password mismatch'
                }
            }
        })
	
	
	
	
	
	
	
	
	

	jQuery.validator.addMethod('lettersonly', function(value,element) {
		return /^[^-\s][a-zA-Z_\s-]+$/.test(value);
	});
	
	jQuery.validator.addMethod('all', function(value,element) {
		return /^[^-\s][a-zA-Z0-9_,.\s-]+$/.test(value);
	});

	jQuery.validator.addMethod('numericOnly', function(value,element) {
		return /^[0-9]+$/.test(value);
	});
	
	
	/* Recruiter register validation form */

})