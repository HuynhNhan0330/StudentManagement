import './Userinformation.scss'
import ScoreBoard from '../ScoreBoard/ScoreBoard';


function UserInformation(props) {
    return (
        <div className='MainContainEr'>
            <div className='UserBasicInfor'>
                <ul class="list-group">
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Mã số sinh viên: </span> {props.maSV}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Họ và tên: </span> {props.tenTK}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Giới tính: </span> {props.gioiTinh}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Ngày sinh: </span>{props.ngaySinh}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Số điện thoại: </span> {props.phone}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Email: </span> {props.email}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Ngành: </span>{props.tenNganh}</li>
                </ul>

            </div>

            
        </div>
    )
}
export default UserInformation;