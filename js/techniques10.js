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
  const taxableCharge = Math.max(0, base - taxThreshold(aReading.year));
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
  // rodash를 사용한 복사.
  const result = _.cloneDeep(original);
  // 부가정보를 덧 붙인다.
  result.baseCharge = calculateBaseCharge(result);
  // 세금을 부과할 소비량 계산 부가정보
  result.taxableCharge = Math.max(
    0,
    aReading.baseCharge - taxThreshold(aReading.year)
  );
  return result;
}

// 클라이언트 3 수정
{
  const rawReading = acquireReading();
  const aReading = enrichReading(rawReading);
  const basicChargeAmount = aReading.baseCharge;
}

// test case 작성
it("check reading unchanged", () => {
  const baseReading = { customer: "ivan", quantity: 10, month: 5, year: 2017 };
  const oracle = _.cloneDeep(baseReading);
  enrichReading(baseReading);
  assert.deepEqual(baseReading, oracle);
});

// 클라이언트 1 수정
{
  const rawReading = acquireReading();
  const aReading = enrichReading(rawReading);
  const baseCharge = aReading.baseCharge;
}
// 클라이언트 2 수정
{
  const rawReading = acquireReading();
  const taxableCharge = enrichReading(rawReading).aReading.taxableCharge;
}
