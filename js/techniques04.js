/**
 * 변수 인라인하기 <-> 변수 추출하기
 */

function price() {
  let basePrice = anOrder.basePrice;
  return basePrice > 1000;
}

function price() {
  return anOrder.basePrice > 1000;
}
