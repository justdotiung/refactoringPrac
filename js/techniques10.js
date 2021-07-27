// 여러 함수를 변환 함수로 묶기

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

// 입력 객체를 그대로 복사해 변환 함수를 만든다
function enrichReading(original) {
  const result = _.cloneDeep(original);
  return result;
}
