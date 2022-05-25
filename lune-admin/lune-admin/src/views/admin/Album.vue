<template>
<div>
  <el-table
     :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    ref="multipleTable"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"> </el-table-column>

    <el-table-column prop="albumName" label="Name" width="300"> </el-table-column>
    <el-table-column label="Pic" width="200">
        <template slot-scope="scope">
          <div class="demo-image__preview">
          <el-image
          style="width: 100px; height: 100px"
          :src="url"
          :preview-src-list="srcList">
        </el-image>
      </div>
          <el-button
              size="mini"
              type="warning"
              plain
              @click="handleUpdatePic(scope.$index, scope.row)">update</el-button>
        </template>
    </el-table-column>
    <el-table-column prop="albumReleaseTime" label="Release Time" width="300" ></el-table-column>
    <el-table-column prop="albumRecordLabel" label="Record Label" width="150" ></el-table-column>
    <el-table-column   align="right">
        <template slot="header">
        <el-input
          v-model="search"
          size="mini"
          placeholder="search..."/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row);dialogVisible = true">Edit</el-button>
          <el-dialog
            title="提示"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
            <span>这是一段信息</span>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
            </span>
          </el-dialog>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row);open()">Del</el-button>
      </template>
    </el-table-column>
  </el-table>

  </div>
</template>
<script>
export default {
  data () {
    return {
      dialogVisible: false,
      tableData: [
        {
          albumName: 'Higdon & Tchaikovsky: Violin Concertos',
          albumPic: 'pic',
          albumReleaseTime: '2010-01-01',
          albumRecordLabel: 'Deustche Grammophon'
        },
        {
          albumName: 'Higdon & Tchaikovsky: Violin Concertos',
          albumPic: 'pic',
          albumReleaseTime: '2010-01-01',
          albumRecordLabel: 'Deustche Grammophon'
        },
        {
          albumName: 'Higdon & Tchaikovsky: Violin Concertos',
          albumPic: 'pic',
          albumReleaseTime: '2010-01-01',
          albumRecordLabel: 'Deustche Grammophon'
        },
        {
          albumName: 'Higdon & Tchaikovsky: Violin Concertos',
          albumPic: 'pic',
          albumReleaseTime: '2010-01-01',
          albumRecordLabel: 'Deustche Grammophon'
        },
        {
          albumName: 'Higdon & Tchaikovsky: Violin Concertos',
          albumPic: 'pic',
          albumReleaseTime: '2010-01-01',
          albumRecordLabel: 'Deustche Grammophon'
        }
      ],
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      srcList: [
        'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
        'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
      ],
      search: '',
      multipleSelection: []
    }
  },

  methods: {
    toggleSelection (rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    filterTag (value, row) {
      return row.user_status === value
    },
    handleUpdatePic (index, row) {
      console.log(index, row)
    },
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleClose (done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    handleDelete (index, row) {
      console.log(index, row)
    },
    open () {
      this.$confirm('Are you sure to delete it?', 'Tip', {
        confirmButtonText: 'yes',
        cancelButtonText: 'no',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: 'Deleted successfully!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Deletions have been reversed'
        })
      })
    }
  }
}
</script>
<style scope>

</style>
