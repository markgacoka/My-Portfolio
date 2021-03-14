async function showName() {
  const responseFromServer = await fetch('/name');
  const textFromResponse = await responseFromServer.text();

  const nameTitle = document.getElementById('name-title');
  nameTitle.innerText = textFromResponse;
}
