/**
 *  함수 인라인하기 <-> 함수 추출하기
 */

function getRating(driver) {
  return moreThanFivelLateDeliveries(driver) ? 2 : 1;
}

function moreThanFivelLateDeliveries(driver) {
  return driver.numberOfLateDeliveries > 5;
}

function getRating(driver) {
  return driver.numberOfLateDeliveries > 5 ? 2 : 1;
}

// 함수 인라인하기 전.

function reportLines(aCustomner) {
  const lines = [];
  gatherCustomerData(lines, aCustomner);
  return lines;
}

function getreportLines(out, aCustomner) {
  out.push(["name", aCustomner.name]);
  out.push(["location", aCustomner.location]);
}

// 함수 인라인하기 후.

function reportLines(aCustomner) {
  const lines = [];
  lines.push(["name", aCustomner.name]);
  lines.push(["location", aCustomner.location]);
  return lines;
}
