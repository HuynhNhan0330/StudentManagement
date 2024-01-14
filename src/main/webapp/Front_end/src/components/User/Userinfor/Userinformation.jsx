import './Userinformation.scss'
import ScoreBoard from '../ScoreBoard/ScoreBoard';


function UserInformation(props) {
    return (
        <div className='MainContainEr'>
            <div className='UserBasicInfor'>
                <ul class="list-group">
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Mã số sinh viên:<span style={{color: 'transparent'}}></span></span> {props.maSV}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Họ và tên:<span style={{color: 'transparent'}}>llllllllll</span></span> {props.tenTK}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Giới tính:<span style={{color: 'transparent'}}>lllllllllll</span>      </span> {props.gioiTinh}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Ngày sinh:<span style={{color: 'transparent'}}>llllllll</span>      </span>{props.ngaySinh}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Số điện thoại:<span style={{color: 'transparent'}}>lll</span> </span> {props.phone}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Email:<span style={{color: 'transparent'}}>llllllllllllllll</span> </span> {props.email}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Ngành:<span style={{color: 'transparent'}}>lllllllllllllll</span> </span>{props.tenNganh}</li>
                </ul>

            </div>

            
        </div>
    )
}
export default UserInformation;