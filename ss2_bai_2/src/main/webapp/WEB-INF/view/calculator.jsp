<form action="/calculate" method="post">
  <input type="text" name="num1" value="${num1} ">
  <input type="text" name="num2" value="${num2}">

  <button type="submit" name="operator" value="add">+</button>
  <button type="submit" name="operator" value="sub">-</button>
  <button type="submit" name="operator" value="mul">*</button>
  <button type="submit" name="operator" value="div">/</button>
</form>

<p>Result: ${result}</p>
