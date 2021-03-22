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

function loadResponses() {
  fetch('/list-responses').then(response => response.json()).then((tasks) => {
    const taskListElement = document.getElementById('task-list');
    tasks.forEach((task) => {
      taskListElement.appendChild(createTaskElement(task));
    })
  });
}

function createResponseElement(response) {
  const taskElement = document.createElement('li');
  taskElement.className = 'task';

  const titleElement = document.createElement('span');
  titleElement.innerText = response.title;

  const deleteButtonElement = document.createElement('button');
  deleteButtonElement.innerText = 'Delete';
  deleteButtonElement.addEventListener('click', () => {
    deleteTask(response);

    taskElement.remove();
  });

  taskElement.appendChild(titleElement);
  taskElement.appendChild(deleteButtonElement);
  return taskElement;
}

function deleteResponse(response) {
  const params = new URLSearchParams();
  params.append('id', response.id);
  fetch('/delete-response', {method: 'POST', body: params});
}
