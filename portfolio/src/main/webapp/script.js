async function showDetails() {
  const responseFromServer = await fetch('/details');
  const jsonFromResponse = await responseFromServer.json();

    const personalListElement = document.getElementById('details-list');
  personalListElement.innerHTML = '';
  personalListElement.appendChild(
      createListElement('First Name: ' + jsonFromResponse.firstName));
  personalListElement.appendChild(
      createListElement('Last Name: ' + jsonFromResponse.lastName));
  personalListElement.appendChild(
      createListElement('Age: ' + jsonFromResponse.currentAge));
  personalListElement.appendChild(
      createListElement('Random fact: ' + jsonFromResponse.randomFact));
}

function createListElement(text) {
  const liElement = document.createElement('li');
  liElement.innerText = text;
  return liElement;
}
