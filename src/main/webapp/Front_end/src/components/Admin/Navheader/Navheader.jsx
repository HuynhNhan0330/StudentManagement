import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { adminPaths } from '../../../routes/AppRoutes';
function NavheaderAdmin() {
  return (
    <Navbar expand="lg" className="bg-body-tertiary" >
      <Container>
        <Navbar.Brand href={adminPaths.major_faculty}>Admin</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href={adminPaths.major_faculty}>Ngành-Khoa</Nav.Link>
            <Nav.Link href={adminPaths.student}>Sinh viên</Nav.Link>
            <Nav.Link href={adminPaths.lecturer}>Giảng viên</Nav.Link>
            <Nav.Link href={adminPaths.class}>Lớp</Nav.Link>
            <Nav.Link href={adminPaths.subject}>Môn học</Nav.Link>
            <Nav.Link href='./'>Đăng xuất</Nav.Link>

          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default NavheaderAdmin;