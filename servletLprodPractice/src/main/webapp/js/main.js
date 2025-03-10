
$('#btn1').on('click', function () {
	fetch('/servletLprodPractice/lprodList.do')
		.then(res => {
			if(!res.ok){
				throw new Error("에러 발생 : " + res.statusText);
			}
			return res.json()
		} ) // 직렬화 전송데이터를 javascript객체로 역직력화
		.then(json => {
			$.each(json, function(i, v){
				// 새로운 요소 option 태그 생성
				code = $(`<option value="${v.lprod_gu}">${v.lprod_name}</option>`);
				$('#lprod').append(code);
			});
		})
		.catch(err => console.log(err));	
		
});	// click end

// lprod의 항목을 change하면 해당 항목의 value값을 가져온다
$('#lprod').on('change', function (){
	guValue = $('#lprod option:selected').val();

	fetch('/servletLprodPractice/prodByLgu.do', {
		method: 'post',
		headers : {"Content-type" :"application/x-www-form-urlencoded"},
		body : "gu=" + guValue
	})
	.then(res => {
		console.log(res);
		if(!res.ok){
			throw new Error("에러발생 : " + res.statusText);
		}
		return res.json();
	})
	.then(json => {
		$.each(json, function(i, v) {
			code = $(`<option value="${v.prod_id}">${v.prod_name}</option>`);
				$('#prod').append(code);
		});
	})
	.catch(err => console.log(err));

}); // change end

$('#prod').on('change', function() {
	idValue = $('#prod option:selected').val();

	fetch('/servletLprodPractice/prodById.do', {
		method: 'post',
		headers: {"Content-type" :"application/x-www-form-urlencoded"},
		body: "id=" + idValue
	})
	.then(res => {
		console.log(res);
		if(!res.ok){
			throw new Error("에러발생 : " + res.statusText);
		}
		return res.json();
	})
	.then(json => {
		code =  "<table border='1'>";
		code += '<tr><th>상품코드</th><th>상품명</th><th>분류코드</th><th>매입단가</th>';
		code += '<th>매출단가</th><th>할인판매단가</th><th>대략적설명</th></tr>';

		code += `<tr><td>${json.prod_id}</td>`;
		code += `<td>${json.prod_name}</td>`;
		code += `<td>${json.lprod_gu}</td>`;
		code += `<td>${json.prod_cost}</td>`;
		code += `<td>${json.prod_price}</td>`;
		code += `<td>${json.prod_sale}</td>`;
		code += `<td>${json.prod_outline}</td></tr></table>`;
		$('#result1').append(code);
	})
	.catch(err => console.log(err));
});
