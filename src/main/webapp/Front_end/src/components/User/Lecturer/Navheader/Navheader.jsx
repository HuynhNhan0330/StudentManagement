import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { lecturerPaths } from '../../../../routes/AppRoutes';
function LecturerNavHeader() {
  return (
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href={lecturerPaths.user_infor}>Student</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href={lecturerPaths.schedule}>Lịch dạy</Nav.Link>
            <Nav.Link href={lecturerPaths.score}>Điểm số</Nav.Link>
            <Nav.Link href={lecturerPaths.user_infor}>Người dùng</Nav.Link>
            <Nav.Link href='./'>Đăng xuất</Nav.Link>

          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default LecturerNavHeader;