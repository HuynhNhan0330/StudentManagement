import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { studentPaths } from '../../../../routes/AppRoutes';
function Navheader() {
  return (
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href={studentPaths.user_infor}>Student</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href={studentPaths.schedule}>Lịch học</Nav.Link>
            <Nav.Link href={studentPaths.score}>Điểm số</Nav.Link>
            <Nav.Link href={studentPaths.user_infor}>Người dùng</Nav.Link>
            <Nav.Link href='./'>Đăng xuất</Nav.Link>

          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Navheader;