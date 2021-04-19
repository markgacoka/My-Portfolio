async function showDetails() {
  const responseFromServer = await fetch('/details');
  const jsonFromResponse = await responseFromServer.json();

    const personalListElement = document.getElementById('details-list');
  personalListElement.innerHTML = '';

async function showName() {
  const responseFromServer = await fetch('/name');
  const textFromResponse = await responseFromServer.text();
  personalListElement.appendChild(
      createListElement('First Name: ' + jsonFromResponse.firstName));
  personalListElement.appendChild(
      createListElement('Last Name: ' + jsonFromResponse.lastName));
  personalListElement.appendChild(
      createListElement('Age: ' + jsonFromResponse.currentAge));
  personalListElement.appendChild(
      createListElement('School Year: ' + jsonFromResponse.schoolYear));
}

  const nameTitle = document.getElementById('name-title');
  nameTitle.innerText = textFromResponse;
function createListElement(text) {
  const liElement = document.createElement('li');
  liElement.innerText = text;
  return liElement;
}
