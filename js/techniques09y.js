// 여러 함수를 클래스로 묶기

// 기본 데이터 구조 형식
{
  reading = { customer: "ivan", quantity: 10, month: 5, year: 2017 };
}

// 위 구조가 쓰이는 클라이언트 1
{
  const aReading = acquireReading();
  const baseCharge = baseRate(aReading.month, aReading) * aReading.quantity;
}

// 위 구조가 쓰이는 클라이언트 2
{
  const aReading = acquireReading();
  const base = baseRate(aReading.month, aReading.year) * aReading.quantity;
  const TaxableCharge = Math.max(0, base - taxThreshold(aReading.year));
}
// 위 구조가 쓰이는 클라이언트 3
{
  const aReading = acquireReading();
  const basicChargeAmount = calculateBaseCharge(aReading);

  function calculateBaseCharge(aReading) {
    return baseRate(aReading.month, aReading.year) * aReading.quantity;
  }
}

// 클라이언트 1,2,3 공통 모듈
// 우선 클래스 변환을 위한 레코드 캡슐화
class Reading {
  constructor(data) {
    this._customer = data.customer;
    this._quantity = data.quantity;
    this._month = data.month;
    this._year = data.year;
  }
  get customer() {
    return this._customer;
  }
  get quantity() {
    return this._quantity;
  }
  get month() {
    return this._month;
  }
  get year() {
    return this._year;
  }
}

// 이미 만들어져있는 calculateBaseCharge 옮기기
// 클라이언트 3 수정
{
  const rawReading = acquireReading();
  const aReading = new Reading(rawReading);
  const basicChargeAmount = aReading.baseCharge;
}
class Reading {
  constructor(data) {
    this._customer = data.customer;
    this._quantity = data.quantity;
    this._month = data.month;
    this._year = data.year;
  }
  get customer() {
    return this._customer;
  }
  get quantity() {
    return this._quantity;
  }
  get month() {
    return this._month;
  }
  get year() {
    return this._year;
  }
  // 함수명 수정
  get baseCharge() {
    return baseRate(this.month, this.year) * this.quantity;
  }

  // 세금부과 함수코드 추출
  get taxableCharge() {
    return Math.max(0, this.baseCharge - taxThreshold(this.year));
  }
}

// 클라이언트 1수정
{
  const rawReading = acquireReading();
  const aReading = new Reading(rawReading);
  const baseCharge = aReading.baseCharge;
}

// 클라이언트 2수정
{
  const rawReading = acquireReading();
  const aReading = new Reading(rawReading);
  const TaxableCharge = aReading.taxableChargej;
}
