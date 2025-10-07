// Show section when a card is clicked
function openSection(sectionId) {
    document.getElementById('dashboard').style.display = 'none';
    document.getElementById('sections').style.display = 'block';
    document.querySelectorAll('.section').forEach(sec => sec.style.display = 'none');
    document.getElementById(sectionId).style.display = 'block';
}

// Back to dashboard
function goBack() {
    document.getElementById('sections').style.display = 'none';
    document.getElementById('dashboard').style.display = 'flex';
}

// Students
const studentForm = document.getElementById('studentForm');
const studentTbody = document.querySelector('#studentTable tbody');
studentForm.addEventListener('submit', e => {
    e.preventDefault();
    const id = document.getElementById('studentId').value;
    const name = document.getElementById('studentName').value;
    const age = document.getElementById('studentAge').value;
    const dept = document.getElementById('studentDept').value;
    const course = document.getElementById('studentCourse').value;
    studentTbody.innerHTML += `<tr>
        <td>${id}</td>
        <td>${name}</td>
        <td>${age}</td>
        <td>${dept}</td>
        <td>${course}</td>
    </tr>`;
    studentForm.reset();
});

// Teachers
const teacherForm = document.getElementById('teacherForm');
const teacherTbody = document.querySelector('#teacherTable tbody');
teacherForm.addEventListener('submit', e => {
    e.preventDefault();
    const id = document.getElementById('teacherId').value;
    const name = document.getElementById('teacherName').value;
    const spec = document.getElementById('teacherSpec').value;
    const dept = document.getElementById('teacherDept').value;
    teacherTbody.innerHTML += `<tr>
        <td>${id}</td>
        <td>${name}</td>
        <td>${spec}</td>
        <td>${dept}</td>
    </tr>`;
    teacherForm.reset();
});

// Courses
const courseForm = document.getElementById('courseForm');
const courseTbody = document.querySelector('#courseTable tbody');
courseForm.addEventListener('submit', e => {
    e.preventDefault();
    const id = document.getElementById('courseId').value;
    const name = document.getElementById('courseName').value;
    const credits = document.getElementById('courseCredits').value;
    const dept = document.getElementById('courseDept').value;
    courseTbody.innerHTML += `<tr>
        <td>${id}</td>
        <td>${name}</td>
        <td>${credits}</td>
        <td>${dept}</td>
    </tr>`;
    courseForm.reset();
});

// Departments
const departmentForm = document.getElementById('departmentForm');
const departmentTbody = document.querySelector('#departmentTable tbody');
departmentForm.addEventListener('submit', e => {
    e.preventDefault();
    const id = document.getElementById('deptId').value;
    const name = document.getElementById('deptName').value;
    departmentTbody.innerHTML += `<tr>
        <td>${id}</td>
        <td>${name}</td>
    </tr>`;
    departmentForm.reset();
});
