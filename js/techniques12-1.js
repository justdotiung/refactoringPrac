// 캡슐화

// 레코드 캡슐화 하기

// 프로그램 전역에서 사용되는 상수 레코드
const organization = { name: "aozmal rntmqpfl", country: "GB" };

// 읽기 예
result += `<h1>${organization.name}</h1>`;
// 쓰기 예
organization.name = newName;

// 상수 캡슐화 ( 변수 캡슐화 하기 )
function getRawDataOfOrganization() {
  return organization;
}

// 읽기 예
result += `<h1>${getRawDataOfOrganization().name}</h1>`;
// 쓰기 예
getRawDataOfOrganization().name = newName;

// 목적: 변수 자체와 내용을 조작하는 방식 통제
// 레코드 캡슐화 작업.
class Organization {
  // 데이터를 개별 필드로 펼쳐 입력데이터 레코드와 연결을 끊어준다.
  constructor(data) {
    this._name = data.name;
    this._country = data.country;
  }
  // 레코드를 갱신하는 코드는 모두 게터와 세터로 변경
  set name(aString) {
    this._name = aString;
  }

  get name() {
    return this._name;
  }

  set country(aCountryCode) {
    this._country = aCountryCode;
  }

  get country() {
    return this._country;
  }
}
const organization = new Organization({
  name: "dozmal rntmqpfl",
  country: "GB",
});

function getOrganization() {
  return organization;
}

getOrganization().name = newName;
result += `<h1>${getOrganization().name}</h1>`;
