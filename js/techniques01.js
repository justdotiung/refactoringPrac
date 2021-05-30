/**
 *  함수 추출하기
 */

function printOwing(invoice) {
  printBanner();
  let outstanding = calculateOutstanding();

  //세부 사항 출력
  console.log(`고객명 ${invoice.customer}`);
  console.log(`고객명 ${outstanding}`);
}

function printOwing(invoice) {
  printBanner();
  let outstanding = calculateOutstanding();
  printDetails(outstanding);

  function printDetails(outstanding) {
    //세부 사항 출력
    console.log(`고객명 ${invoice.customer}`);
    console.log(`고객명 ${outstanding}`);
  }
}

// 추출하기 전.

function printOwing(invoice) {
  let outstanding = calculateOutstanding();

  console.log("**********");
  console.log("** 고객채무 **");
  console.log("**********");

  // 미해결 채무(outstanding)를 계산한다.
  for (const o of invoice.orders) {
    outstanding += o.amount;
  }

  // 마감일 (dueDate)을 기록한다.
  const today = Clock.today;
  invoice.dueDate = new Date(
    today.getFullYear(),
    today.getMonth(),
    today.getDate() + 30
  );

  // 세부 사항을 출력한다.
  console.log(`고객명: ${invoice.customer}`);
  console.log(`채무액: ${outstanding}`);
  console.log(`마감일: ${invoice.dueDate.toLocaleDateString()}`);
}

// 추출하기 후.

function printOwing(invoice) {
  printBanner();
  const outstanding = calculateOutstanding(invoice);
  recordDueDate(invoice);
  printDetails(invoice, outstanding);
}

function printBanner() {
  console.log("**********");
  console.log("** 고객채무 **");
  console.log("**********");
}

function printDetails(invoice, outstanding) {
  // 세부 사항을 출력한다.
  console.log(`고객명: ${invoice.customer}`);
  console.log(`채무액: ${outstanding}`);
  console.log(`마감일: ${invoice.dueDate.toLocaleDateString()}`);
}

function recordDueDate(invoice) {
  // 마감일 (dueDate)을 기록한다.
  const today = Clock.today;
  invoice.dueDate = new Date(
    today.getFullYear(),
    today.getMonth(),
    today.getDate() + 30
  );
}

function calculateOutstanding(invoice) {
  // 미해결 채무(outstanding)를 계산한다.
  let result = 0;
  for (const o of invoice.orders) {
    result += o.amount;
  }

  return result;
}
