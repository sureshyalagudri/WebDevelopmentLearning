let tableHeaders = ["ID", "First Name", "Middle Name", "Last Name", "Gender", "Birth Date", "Country", "Address", "Phone", "Email", "Password"]

const createScoreboardTable = () => {
	// Remove all children from scoreboard div (if any)
	let tablediv = document.querySelector("div.scoreboard");
	while (tablediv.firstChild) tablediv.removeChild(tablediv.firstChild)

	// Create the table.
	let scoreboardTable = document.createElement('table')
	scoreboardTable.className = 'scoreboardTable'
	let scoreboardTableHead = document.createElement('thead') // Creates the table header group element
	scoreboardTableHead.className = 'scoreboardTableHead'
	let scoreboardTableHeaderRow = document.createElement('tr') // Creates the row that will contain the headers
	scoreboardTableHeaderRow.className = 'scoreboardTableHeaderRow'
	// Will iterate over all the strings in the tableHeader array and will append the header cells to the table header row
	tableHeaders.forEach(header => {
		let scoreHeader = document.createElement('th') // Creates the current header cell during a specific iteration
		scoreHeader.innerText = header
		scoreboardTableHeaderRow.append(scoreHeader) // Appends the current header cell to the header row
	})
	scoreboardTableHead.append(scoreboardTableHeaderRow) // Appends the header row to the table header group element
	scoreboardTable.append(scoreboardTableHead)
	let scoreboardTableBody = document.createElement('tbody') // Creates the table body group element
	scoreboardTableBody.className = "scoreboardTable-Body"
	scoreboardTable.append(scoreboardTableBody) // Appends the table body group element to the table
	tablediv.append(scoreboardTable) // Appends the table to the scoreboard div
}
// The function below will accept a single score and its index to create the global ranking
const appendScores = (user, index) => {
	const scoreboardTable = document.querySelector('.scoreboardTable') // Find the table we created
	let newRow = document.createElement('tr') // Create the current table row
	newRow.className = 'scoreboardTableBodyRow'

	let id = document.createElement('td')
	id.innerText = user.id

	let firstName = document.createElement('td')
	firstName.innerText = user.firstName

	let middleName = document.createElement('td')
	middleName.innerText = user.middleName

	let lastName = document.createElement('td')
	lastName.innerText = user.lastName

	let gender = document.createElement('td')
	gender.innerText = user.gender

	let birthDate = document.createElement('td')
	birthDate.innerText = user.birthDate

	let country = document.createElement('td')
	country.innerText = user.country

	let address = document.createElement('td')
	address.innerText = user.address

	let phone = document.createElement('td')
	phone.innerText = user.phone

	let email = document.createElement('td')
	email.innerText = user.email

	let password = document.createElement('td')
	password.innerText = user.password

	newRow.append(id, firstName, middleName, lastName, gender, birthDate, country, address, phone, email, password)
	scoreboardTable.append(newRow)
}

const getUsers = () => {
	fetch('http://localhost:8080/allusers')
		.then(res => res.json())
		.then(users => {
			createScoreboardTable()
			for (const user of users) {
				let index = users.indexOf(user) + 1
				appendScores(user, index)
			}
		})
}