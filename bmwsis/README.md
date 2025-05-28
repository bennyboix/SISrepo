# BMW-SIS Student Information System

A comprehensive Student Information System built with Spring Boot, featuring student enrollment, grade management, and schedule viewing capabilities.

## Features

### Student Portal
- **Secure Login**: Students can log in using their Student ID and password
- **Dashboard**: Overview of student information and quick access to all features
- **Grade Viewing**: View midterm and final grades with pass/fail status
- **Schedule Management**: View current enrolled subjects with detailed schedule information
- **Subject Enrollment**: Enroll in available IT subjects when enrollment period is open

### System Features
- **IT-Focused Curriculum**: All subjects are Information Technology related
- **Enrollment Period Control**: Administrators can control when enrollment is open/closed
- **Slot Management**: Prevents over-enrollment with maximum slot limits per class
- **Year Level Restrictions**: Students can only enroll in subjects appropriate for their year level
- **Faculty Assignment**: Each subject schedule is assigned to a specific faculty member

## Technology Stack

- **Backend**: Spring Boot 3.5.0
- **Database**: H2 (in-memory for development)
- **ORM**: Spring Data JPA
- **Template Engine**: Thymeleaf
- **Frontend**: HTML5, CSS3, JavaScript
- **Build Tool**: Maven

## Getting Started

### Prerequisites
- Java 24 or higher
- Maven 3.6 or higher

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd bmwsis
```

2. Run the application:
```bash
./mvnw spring-boot:run
```

3. Access the application:
- Main page: http://localhost:5521/sis
- Student login: http://localhost:5521/student/login
- H2 Database Console: http://localhost:5521/h2-console

### Default Test Accounts

#### Students
| Student ID | Password | Name | Year Level |
|------------|----------|------|------------|
| 2021-0001 | password123 | John Doe | 3 |
| 2021-0002 | password123 | Jane Smith | 2 |
| 2022-0001 | password123 | Mike Johnson | 2 |

#### Faculty
| Faculty ID | Name | Department |
|------------|------|------------|
| FAC-001 | Dr. Maria Garcia | Computer Science |
| FAC-002 | Prof. Robert Chen | Information Technology |
| FAC-003 | Dr. Sarah Williams | Software Engineering |
| FAC-004 | Prof. David Brown | Database Systems |
| FAC-005 | Dr. Lisa Anderson | Network Security |

## Available IT Subjects

### First Year (Year 1)
- IT-101: Introduction to Programming (3 units)
- IT-102: Web Development Fundamentals (3 units)
- IT-103: Computer Fundamentals (3 units)
- IT-104: Mathematics for IT (3 units)

### Second Year (Year 2)
- IT-201: Object-Oriented Programming (3 units)
- IT-202: Database Management Systems (3 units)
- IT-203: Advanced Web Development (3 units)
- IT-204: Computer Networks (3 units)
- IT-205: Data Structures and Algorithms (3 units)

### Third Year (Year 3)
- IT-301: Software Engineering (3 units)
- IT-302: Advanced Database Systems (3 units)
- IT-303: Web Application Frameworks (3 units)
- IT-304: Mobile Application Development (3 units)
- IT-305: Cybersecurity Fundamentals (3 units)
- IT-306: System Analysis and Design (3 units)

## How to Use

### For Students

1. **Login**: Use your Student ID and password to access the student portal
2. **Dashboard**: View your basic information and navigate to different sections
3. **View Grades**: Check your academic performance including:
   - Subject Code and Description
   - Faculty Name
   - Section Code
   - Midterm and Final grades
   - Final rating and pass/fail status
4. **View Schedule**: See your current enrolled subjects with:
   - Subject details and units
   - Class schedule (day, time, room)
   - Faculty information
   - Total enrolled units
5. **Enrollment**: When enrollment is open:
   - Browse available subjects for your year level
   - View class schedules and faculty assignments
   - Check available slots
   - Enroll in subjects with available slots

### Key Features

#### Grade Management
- Students can view their grades in a comprehensive table format
- Grades include midterm, finals, and calculated final rating
- Status indicators show if the student passed or failed
- Historical grades are organized by semester and academic year

#### Schedule Viewing
- Current enrolled subjects are displayed with complete schedule information
- Shows section codes, class times, room assignments, and faculty
- Displays total units enrolled
- Easy navigation to enrollment page if no classes are enrolled

#### Smart Enrollment System
- Only shows subjects appropriate for the student's year level
- Prevents enrollment when slots are full
- Displays real-time slot availability
- Enrollment is controlled by administrative enrollment periods
- Students cannot enroll in the same subject multiple times

## Database Schema

The system uses the following main entities:
- **Student**: Student information and credentials
- **Subject**: IT course catalog with prerequisites
- **Faculty**: Instructor information
- **SubjectSchedule**: Class schedules with time, room, and faculty assignments
- **Enrollment**: Student-subject enrollment records
- **Grade**: Academic performance records
- **EnrollmentPeriod**: Administrative control for enrollment windows

## Configuration

### Database Configuration
The application uses H2 in-memory database by default. Configuration can be found in `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=create-drop
```

### Server Configuration
- Default port: 5521
- Application name: bmwsis

## Development

### Project Structure
```
src/main/java/com/sisregistration/bmwsis/
├── entity/          # JPA entities
├── repository/      # Data access layer
├── service/         # Business logic
├── controller/      # Web controllers
└── config/          # Configuration classes

src/main/resources/
├── templates/       # Thymeleaf templates
├── static/          # Static resources
└── application.properties
```

### Adding New Features
1. Create or modify entities in the `entity` package
2. Add repository methods in the `repository` package
3. Implement business logic in the `service` package
4. Create web endpoints in the `controller` package
5. Design UI templates in the `templates` directory

## Future Enhancements

- Faculty portal for grade management
- Administrative portal for system management
- Email notifications for enrollment
- Advanced reporting and analytics
- Mobile-responsive design improvements
- Integration with external systems

## Support

For technical support or questions about the system, please contact the development team or refer to the system documentation. 