// 변수 이름 바꾸기
let tpHd = "untitled";
// 변수만 읽을때
result += `<h1>${tpHd}</h1>`;
// 값을 수정하는곳 존재
tpHd = obj["articleTitle"];
// 위와 같을때 주로 변수 캡슐화
result += `<h1>${title()}</h1>`;

setTile(obj["articleTitle"]);

// 캡슐화 후 변수명 변경
let _title = "untitled";

function title() {
  return _title;
}

function setTitle(arg) {
  _title = arg;
}
